package heroes;

public final class Wizard extends Player {
    public Wizard() {
        super();
        this.setInitialHp(getConstants().getBaseHpWizard() + getConstants().
                getHpWizardPerLevel() * this.getLevel());
        this.setHp(this.getInitialHp());
    }

    public void fight(final Player enemy) {
        if (enemy instanceof Rogue) {
            Rogue rogue = (Rogue) enemy;
            int drainDmg = drain(rogue);
            int deflectDmg = deflect(rogue);
            deflectDmg = Math.round(deflectDmg + deflectDmg * getConstants().
                    getRogueMultiplierDeflect());
            if (this.getTerrain().equals('D')) {
                deflectDmg += Math.round(deflectDmg * getConstants().getDrainBonusTerrain());
            }
            if (rogue.getHp() - drainDmg - deflectDmg <= 0) {
                rogue.setHp(0);
                rogue.setDead(true);
                this.setXp(this.getXp() + Math.max(0, getConstants().getWinnerXP()
                        - (this.getLevel() - rogue.getLevel())
                        * getConstants().getWinnerXpMultiplier()));
            } else {
                rogue.setHp(rogue.getHp() - drainDmg - deflectDmg);
            }
            this.setFight(true);
            if (!rogue.isFight()) {
                rogue.fight(this);
            }

        } else if (enemy instanceof Wizard) {
            Wizard wizard = (Wizard) enemy;
            int drainDmg = drain(wizard);
            if (wizard.getHp() - drainDmg <= 0) {
                wizard.setHp(0);
                wizard.setDead(true);
                this.setXp(this.getXp() + Math.max(0, getConstants().getWinnerXP()
                        - (this.getLevel() - wizard.getLevel())
                        * getConstants().getWinnerXpMultiplier()));
            } else {
                wizard.setHp(wizard.getHp() - drainDmg);
            }
        } else if (enemy instanceof Knight) {
            Knight knight = (Knight) enemy;
            int drainDmg = drain(knight);
            int deflectDmg = deflect(knight);
            deflectDmg = Math.round(deflectDmg + deflectDmg * getConstants().
                    getKnightMultiplierDeflect());
            if (this.getTerrain().equals('D')) {
                deflectDmg += Math.round(deflectDmg * getConstants().getDrainBonusTerrain());
            }
            if (knight.getHp() - drainDmg - deflectDmg <= 0) {
                knight.setHp(0);
                knight.setDead(true);
                this.setXp(this.getXp() + Math.max(0, getConstants().getWinnerXP()
                        - (this.getLevel() - knight.getLevel())
                        * getConstants().getWinnerXpMultiplier()));
            } else {
                knight.setHp(knight.getHp() - drainDmg - deflectDmg);
            }
            this.setFight(true);
            if (!knight.isFight()) {
                knight.fight(this);
            }
        } else if (enemy instanceof Pyromancer) {
            Pyromancer pyromancer = (Pyromancer) enemy;
            int drainDmg = drain(pyromancer);
            int deflectDmg = deflect(pyromancer);
            deflectDmg = Math.round(getConstants().getPyromancerMultiplierDeflect()
                    * deflectDmg);
            if (this.getTerrain().equals('D')) {
                deflectDmg += Math.round(deflectDmg * getConstants().getDrainBonusTerrain());
            }
            if (pyromancer.getHp() - drainDmg - deflectDmg <= 0) {
                pyromancer.setHp(0);
                pyromancer.setDead(true);
                this.setXp(this.getXp() + Math.max(0, getConstants().getWinnerXP()
                        - (this.getLevel() - pyromancer.getLevel())
                        * getConstants().getWinnerXpMultiplier()));
            } else {
                pyromancer.setHp(pyromancer.getHp() - drainDmg - deflectDmg);
            }
            this.setFight(true);
            if (!pyromancer.isFight()) {
                pyromancer.fight(this);
            }
        }
    }

    public int drain(final Rogue rogue) {
        float procent = getConstants().getBaseDrainProcent() + getConstants().
                getDrainProcentPerLevel() * this.getLevel();
        int dmg = Math.round(procent * Math.min(getConstants().getMinProcentMultiplier()
                * rogue.getInitialHp(), rogue.getHp()));
        if (this.getTerrain().equals('D')) {
            dmg = Math.round(dmg + dmg * getConstants().getDrainBonusTerrain());
        }
        dmg -= Math.round(getConstants().getRogueDrainMultiplier() * dmg);
    return dmg;
    }

    public int drain(final Knight knight) {
        float procent = getConstants().getBaseDrainProcent() + getConstants().
                getDrainProcentPerLevel() * this.getLevel();
        int dmg = Math.round(procent * Math.min(getConstants().getMinProcentMultiplier()
                * knight.getInitialHp(), knight.getHp()));
        if (this.getTerrain().equals('D')) {
            dmg = Math.round(dmg + dmg * getConstants().getDrainBonusTerrain());
        }
        dmg += Math.round(getConstants().getKnightDrainMultiplier() * dmg);
        return dmg;
    }

    public int drain(final Pyromancer pyromancer) {
        float procent = getConstants().getBaseDrainProcent() + getConstants().
                getDrainProcentPerLevel() * this.getLevel();
        procent = procent - getConstants().getPyromancerDrainMultiplier() * procent;
        int dmg = Math.round(procent * Math.min(getConstants().getMinProcentMultiplier()
                        * pyromancer.getInitialHp(),
                pyromancer.getHp()));
        if (this.getTerrain().equals('D')) {
            dmg = Math.round(dmg + dmg * getConstants().getDrainBonusTerrain());
        }
        return dmg;
    }

    public int drain(final Wizard wizard) {
        float procent = getConstants().getBaseDrainProcent() + getConstants().
                getDrainProcentPerLevel() * this.getLevel();
        int dmg = Math.round((procent + (getConstants().getWizardDrainMultiplier()
                * procent)) * Math.min(getConstants().getMinProcentMultiplier()
                        * wizard.getInitialHp(),
                wizard.getHp()));
        if (this.getTerrain().equals('D')) {
            dmg = Math.round(dmg + dmg * getConstants().getDrainBonusTerrain());
        }
        return dmg;
    }

    public int deflect(final Rogue rogue) {
        int deflectDmg;
        float procent = getConstants().getDeflectBaseProcent()
                + getConstants().getDeflectProcentPerLevel() * this.getLevel();
        if (procent > getConstants().getMaxProcent()) {
            procent = getConstants().getMaxProcent();
        }
        deflectDmg = Math.round((rogue.getBackstabDmg()
                + rogue.getParalysisDmg()) * procent);
        return deflectDmg;
    }

    public int deflect(final Knight knight) {
        int deflectDmg;
        float procent = getConstants().getDeflectBaseProcent()
                + getConstants().getDeflectProcentPerLevel() * this.getLevel();
        if (procent > getConstants().getMaxProcent()) {
            procent = getConstants().getMaxProcent();
        }
        deflectDmg = Math.round((knight.getExecuteDmg() + knight.getSlamDmg()) * procent);
        return deflectDmg;
    }

    public int deflect(final Pyromancer pyromancer) {
        int deflectDmg;
        float procent = getConstants().getDeflectBaseProcent()
                + getConstants().getDeflectProcentPerLevel() * this.getLevel();
        if (procent > getConstants().getMaxProcent()) {
            procent = getConstants().getMaxProcent();
        }
        deflectDmg = Math.round((pyromancer.getFireblastDmg()
                + pyromancer.getIgniteDmg()) * procent);
        return deflectDmg;
    }
}
