commit:
    @git add . 
    @git commit -am "wip" || true

test:
    clear
    @./gradlew test
    
test-commit:
    just test 
    just commit
    
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