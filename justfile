goal +MESSAGE:
    git pull --rebase
    @git commit --allow-empty -m "{{MESSAGE}}"
    git push

commit:
    @git add . 
    -@git commit -am "wip"

test:
    clear
    @./gradlew test
    
test-commit:
    git pull --rebase
    just test 
    just commit
    git push
    
tdd:
    watchexec -e java just test

tdd-commit:
    watchexec -e java just test-commit

revert:
    @git reset --hard &> /dev/null
    @git clean -df &> /dev/null
    @echo -e "\033[0;31m=== REVERTED ==="
    
tcr:
    @just test && just commit || just revert