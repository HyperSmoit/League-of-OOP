package heroes;
public final class Knight extends Player {
    private Integer slamDmg;
    private Integer executeDmg;

    public Knight() {
        super();
        super.setInitialHp(getConstants().getBaseHpKnight() + getConstants().
                getHpKnightPerLevel() * this.getLevel());
        this.setHp(this.getInitialHp());
    }

    public Integer getSlamDmg() {
        return slamDmg;
    }

    public Integer getExecuteDmg() {
        return executeDmg;
    }

    public void fight(final Player enemy) {
        int slamDmg = slam(enemy);
        int executeDmg = execute();

        if (enemy instanceof Rogue) {
            Rogue rogue = (Rogue) enemy;
            executeDmg = Math.round(executeDmg + executeDmg * getConstants().getRogueExecute());
            slamDmg = Math.round(slamDmg - slamDmg * getConstants().getRogueSlam());
            this.setFight(true);
            if (!rogue.isFight()) {
                rogue.fight(this);
            }
        } else if (enemy instanceof Wizard) {
            Wizard wizard = (Wizard) enemy;
            this.executeDmg = executeDmg;
            this.slamDmg = slamDmg;
            executeDmg = Math.round(executeDmg - executeDmg * getConstants().getWizardExecute());
            slamDmg = Math.round(slamDmg + slamDmg * getConstants().getWizardSlam());

            this.setFight(true);
            if (!wizard.isFight()) {
                wizard.fight(this);
            }

        } else if (enemy instanceof Knight) {
            Knight knight = (Knight) enemy;
            slamDmg = Math.round(slamDmg + slamDmg * getConstants().getKnightSlam());
            this.setFight(true);
            if (!knight.isFight()) {
                knight.fight(this);
            }

        } else if (enemy instanceof Pyromancer) {
            Pyromancer pyromancer = (Pyromancer) enemy;
            slamDmg = Math.round(slamDmg - slamDmg * getConstants().getPyroSlam());
            executeDmg = Math.round(getConstants().getPyroExecute() * executeDmg);
            this.setFight(true);
            if (!pyromancer.isFight()) {
                pyromancer.fight(this);
            }
        }
        if (enemy.getHp() - slamDmg - executeDmg <= 0) {
            enemy.setHp(0);
            enemy.setDead(true);
            this.setXp(this.getXp() + Math.max(0, getConstants().getWinnerXP() - (this.getLevel()
                    - enemy.getLevel()) * getConstants().getWinnerXpMultiplier()));
        } else {
            enemy.setHp(enemy.getHp() - slamDmg - executeDmg);
        }

    }

    public int execute() {
        int baseDmg = getConstants().getExecuteDmg() + getConstants().getExecuteDmgPerLevel()
                * this.getLevel();
        if (this.getTerrain().equals('L')) {
            return (baseDmg + Math.round(baseDmg * getConstants().getKnightBonusTerrain()));
        }
        return baseDmg;
    }

    public int slam(final Player enemy) {
        int basedmg = getConstants().getSlamDmg() + getConstants().getSlamDmgPerLevel()
                * this.getLevel();
        enemy.setStunnedRounds(1);
        enemy.setStunned(true);
        if (this.getTerrain().equals('L')) {
            return (basedmg + Math.round(basedmg * getConstants().getKnightBonusTerrain()));
        }
        return basedmg;
    }

}
