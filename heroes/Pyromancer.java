package heroes;

public final class Pyromancer extends Player {
    private Integer fireblastDmg;
    private Integer igniteDmg;
    public Pyromancer() {
        super();
        super.setInitialHp(getConstants().getBaseHpPyromancer() + getConstants().
                getHpPyromancerPerLevel() * this.getLevel());
        this.setHp(this.getInitialHp());
    }

    public Integer getFireblastDmg() {
        return fireblastDmg;
    }

    public Integer getIgniteDmg() {
        return igniteDmg;
    }

    public void fight(final Player enemy) {
        int fireblastDmg = fireblast();
        int igniteDmg = ignite(enemy);

        if (enemy instanceof Rogue) {
            Rogue rogue = (Rogue) enemy;
            fireblastDmg = Math.round(fireblastDmg * getConstants().getRogueFireblast());
            igniteDmg = Math.round(igniteDmg * getConstants().getRogueIgnite());
            this.setFight(true);
            if (!rogue.isFight()) {
                rogue.fight(this);
            }
        } else if (enemy instanceof Wizard) {
            Wizard wizard = (Wizard) enemy;
            this.fireblastDmg = fireblastDmg;
            this.igniteDmg = igniteDmg;
            fireblastDmg = Math.round(fireblastDmg * getConstants().getWizardFireblast());
            igniteDmg = Math.round(igniteDmg * getConstants().getWizardIgnite());
            this.setFight(true);
            if (!wizard.isFight()) {
                wizard.fight(this);
            }
        } else if (enemy instanceof Knight) {
            Knight knight = (Knight) enemy;
            fireblastDmg = fireblast(knight);
            this.setFight(true);
            if (!knight.isFight()) {
                knight.fight(this);
            }
        } else if (enemy instanceof Pyromancer) {
            Pyromancer pyromancer = (Pyromancer) enemy;
            fireblastDmg = Math.round(fireblastDmg * getConstants().getPyroFireblast());
            igniteDmg = Math.round(igniteDmg * getConstants().getPyroIgnite());
            this.setFight(true);
            if (!pyromancer.isFight()) {
                pyromancer.fight(this);
            }
        }

        if (enemy.getHp() - fireblastDmg - igniteDmg <= 0) {
            enemy.setHp(0);
            enemy.setDead(true);
            this.setXp(this.getXp() + Math.max(0, getConstants().getWinnerXP() - (this.getLevel()
                    - enemy.getLevel()) * getConstants().getWinnerXpMultiplier()));
        } else {
            enemy.setHp(enemy.getHp() - fireblastDmg - igniteDmg);
        }
    }

    public int fireblast() {
        int baseDmg = getConstants().getFireblastDmg() + getConstants().
                getFireblastDmgPerLevel() * this.getLevel();
        if (this.getTerrain().equals('V')) {
            baseDmg = Math.round(baseDmg * getConstants().getPyroBonusTerrain());
        }
        return baseDmg;
    }

    public int fireblast(final Knight knight) {
        int baseDmg = getConstants().getFireblastDmg() + getConstants().
                getFireblastDmgPerLevel() * this.getLevel();
        baseDmg = Math.round(baseDmg * getConstants().getKnightFireblast());
        if (this.getTerrain().equals('V')) {
            baseDmg = Math.round(baseDmg * getConstants().getPyroBonusTerrain());
        }
        return baseDmg;
    }

    public int ignite(final Player enemy) {
        int baseDmg = getConstants().getIgniteBaseDmg() + getConstants().
                getIgniteDmgPerLevel() * this.getLevel();
        int baseDOT = getConstants().getIgniteDOT() + getConstants().getIgniteDOTPerLevel()
                * this.getLevel();
        enemy.setNrOfRoundsDOT(getConstants().getIgniteRounds());
        if (enemy instanceof Rogue) {
            Rogue rogue = (Rogue) enemy;
            rogue.setDot(Math.round(getConstants().getRogueIgnite() * baseDOT));

        } else if (enemy instanceof Wizard) {
            Wizard wizard = (Wizard) enemy;
            wizard.setDot(Math.round(getConstants().getWizardIgnite() * baseDOT));

        } else if (enemy instanceof Knight) {
            Knight knight = (Knight) enemy;
            baseDmg = Math.round(baseDmg * getConstants().getKnightIgnite());
            knight.setDot(Math.round(getConstants().getKnightIgnite() * baseDOT));

        } else if (enemy instanceof Pyromancer) {
            Pyromancer pyromancer = (Pyromancer) enemy;
            pyromancer.setDot(Math.round(getConstants().getPyroIgnite() * baseDOT));
        }
        if (this.getTerrain().equals('V')) {
            baseDmg = Math.round(baseDmg * getConstants().getPyroBonusTerrain());
            enemy.setDot(Math.round(enemy.getDot() * getConstants().getPyroBonusTerrain()));
        }
        return baseDmg;
    }
}
