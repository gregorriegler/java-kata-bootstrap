class RpgCharacter {
    private final int level;
    private int health = 1000;
    private boolean alive = true;

    public RpgCharacter(int level) {
        this.level = level;
    }

    public void heal(int amount) {
        this.health = Math.min(1000, this.health + amount);
    }

    public int getHealth() {
        return health;
    }

    public void damage(RpgCharacter attacker, int damage) {
        if (this == attacker) {
            return;
        }

        this.health -= correctDamage(damage, attacker.level);

        if(this.health < 0) {
            this.health = 0;
            this.alive = false;
        }
    }

    private int correctDamage(int damage, int attackerLevel) {
        if(this.level >= attackerLevel + 5) return damage/2;
        return damage;
    }

    public boolean isAlive() {
        return alive;
    }
}
