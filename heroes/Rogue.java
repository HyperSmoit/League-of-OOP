package heroes;

public final class Rogue extends Player {
    private Integer numberOfHit = 0;
    private Integer backstabDmg;
    private Integer paralysisDmg;

    public Rogue() {
        super();
        super.setInitialHp(getConstants().getBaseHpRogue()
                + getConstants().getHpRoguePerLevel() * this.getLevel());
        this.setHp(this.getInitialHp());
    }

    public Integer getBackstabDmg() {
        return backstabDmg;
    }

    public Integer getParalysisDmg() {
        return paralysisDmg;
    }

    public void fight(final Player enemy) {
        int backstabDmg = backstab();
        int paralysisDmg = paralysis(enemy);

        if (enemy instanceof Wizard) {
            Wizard wizard = (Wizard) enemy;
            this.backstabDmg = backstabDmg;
            this.paralysisDmg = paralysisDmg;
            backstabDmg = Math.round(backstabDmg + backstabDmg * getConstants().
                    getWizardBackstabMultiplier());
            paralysisDmg = Math.round(paralysisDmg + paralysisDmg * getConstants().
                    getWizardParalysisMultiplier());
            enemy.setDot(paralysisDmg);
            this.setFight(true);
            if (!wizard.isFight()) {
                wizard.fight(this);
            }
        } else if (enemy instanceof Knight) {
            Knight knight = (Knight) enemy;
            backstabDmg = Math.round(backstabDmg + backstabDmg * getConstants().
                    getKnightBackstabMultiplier());
            paralysisDmg = Math.round(paralysisDmg - paralysisDmg * getConstants().
                    getKnightParalysisMultiplier());
            knight.setDot(paralysisDmg);
            this.setFight(true);
            if (!knight.isFight()) {
                knight.fight(this);
            }
        } else if (enemy instanceof Rogue) {
            Rogue rogue = (Rogue) enemy;
            backstabDmg = Math.round(backstabDmg + backstabDmg * getConstants().
                    getRogueBackstabMultiplier());
            paralysisDmg = Math.round(paralysisDmg + paralysisDmg * getConstants().
                    getRogueParalysisMultiplier());
            enemy.setDot(paralysisDmg);
            this.setFight(true);
            if (!rogue.isFight()) {
                rogue.fight(this);
            }
        } else if (enemy instanceof Pyromancer) {
            Pyromancer pyromancer = (Pyromancer) enemy;
            backstabDmg = Math.round(backstabDmg + backstabDmg * getConstants().
                    getPyroBackstabMultiplier());
            paralysisDmg = Math.round(paralysisDmg + paralysisDmg * getConstants().
                    getPyroParalysisMultiplier());
            enemy.setDot(paralysisDmg);
            this.setFight(true);
            if (!pyromancer.isFight()) {
                pyromancer.fight(this);
            }
        }

        if (enemy.getHp() - backstabDmg - paralysisDmg <= 0) {
            enemy.setHp(0);
            enemy.setDead(true);
            this.setXp(this.getXp() + Math.max(0, getConstants().getWinnerXP() - (this.getLevel()
                    - enemy.getLevel()) * getConstants().getWinnerXpMultiplier()));
        } else {
            enemy.setHp(enemy.getHp() - backstabDmg - paralysisDmg);
        }
    }

    public int backstab() {
        this.setDmg(getConstants().getBackstabDmg() + getConstants().
                getBackstabDmgPerLevel() * this.getLevel());
        if (this.getTerrain().equals('W')) {
            this.setDmg(Math.round(this.getDmg() + this.getDmg() * getConstants().
                    getRogueBonusTerrain()));
            if (numberOfHit % getConstants().getCriticalStrikeNumber() == 0) {
                this.setDmg(Math.round(this.getDmg() * getConstants().getCriticalHit()));
            }
            numberOfHit++;
        } else {
            numberOfHit++;
        }
        return this.getDmg();
    }

    public int paralysis(final Player enemy) {
        int paralysisDmg = getConstants().getParalysisDmg()
                + getConstants().getParalysisDmgPerLevel() * this.getLevel();
        enemy.setNrOfRoundsDOT(getConstants().getParalysisRounds());

        enemy.setStunnedRounds(getConstants().getParalysisRounds());
        enemy.setStunned(true);

        if (this.getTerrain().equals('W')) {
            paralysisDmg = Math.round(paralysisDmg + paralysisDmg
                    * getConstants().getRogueBonusTerrain());
            enemy.setNrOfRoundsDOT(getConstants().getParalysisRoundsExtended());
            enemy.setStunnedRounds(getConstants().getParalysisRoundsExtended());
        }
        this.setDmg(this.getDmg() + paralysisDmg);
        return paralysisDmg;
    }
}
