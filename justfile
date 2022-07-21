goal +MESSAGE:
    git pull --rebase
    git commit --allow-empty -m "{{MESSAGE}}"
    git push

commit:
    @git add . 
    -@git commit -am "wip"

test:
    clear
    @./gradlew test
    
integrate:
    git pull --rebase
    just test 
    just commit
    git push
    
tdd:
    watchexec -e java just test

ci:
    watchexec -e java just integrate

revert:
    @git reset --hard &> /dev/null
    @git clean -df &> /dev/null
    @echo -e "\033[0;31m=== REVERTED ==="
    
tcr:
    @just test && just commit || just revert
