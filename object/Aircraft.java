class Aircraft {
    private int maxAmmo;
    private int baseDamage;
    private int currentAmmo;

    public Aircraft(int maxAmmo, int baseDamage) {
        this.maxAmmo = maxAmmo;
        this.baseDamage = baseDamage;
        this.currentAmmo = 0;
    }

    public int fight() {
        int damage = currentAmmo * baseDamage;
        currentAmmo = 0;
        return damage;
    }

    public int refillAmmo(int ammoToFill) {
        int remainingAmmo = maxAmmo - currentAmmo;
        if (ammoToFill <= remainingAmmo) {
            currentAmmo += ammoToFill;
            return 0;
        } else {
            currentAmmo = maxAmmo;
            return ammoToFill - remainingAmmo;
        }
    }

    public String getType() {
        return this.getClass().getSimpleName();
    }

    public String getStatus() {
        return "Type " + getType() + ", Ammo: " + currentAmmo + ", Base Damage: " + baseDamage +
                ", All Damage: " + (currentAmmo * baseDamage);
    }

    public boolean isPriority() {
        return false;
    }
}

class F16 extends Aircraft {
    public F16() {
        super(8, 30);
    }
}

class F35 extends Aircraft {
    public F35() {
        super(12, 50);
    }

    @Override
    public boolean isPriority() {
        return true;
    }

}


