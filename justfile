goal +MESSAGE:
    git pull --rebase
    git commit --allow-empty -m "Goal: {{MESSAGE}}"
    git push

test:
    clear
    @./gradlew test
    
commit:
    @git add . 
    -@git commit -am "wip"
    
test-commit:
    just test
    just commit
    
integrate:
    git pull --rebase
    just test-commit
    git push
    
tdd:
    watchexec -e java just test

tdd-commit:
    watchexec -e java just test-commit

ci:
    watchexec -e java just integrate

revert:
    @git reset --hard &> /dev/null
    @git clean -df &> /dev/null
    @echo -e "\033[0;31m=== REVERTED ==="
    
tcr:
    @just test && just commit || just revert
