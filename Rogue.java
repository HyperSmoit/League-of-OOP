public class Rogue extends Player{
    private Integer numberOfHit = 0;
    private Integer backstabDmg;
    private Integer ParalysisDmg;

    public Rogue() {
        super();
        super.setInitialHp(600 + 40*this.getLevel());
        this.setHp(this.getInitialHp());
    }

    public Integer getBackstabDmg() {
        return backstabDmg;
    }

    public void setBackstabDmg(Integer backstabDmg) {
        this.backstabDmg = backstabDmg;
    }

    public Integer getParalysisDmg() {
        return ParalysisDmg;
    }

    public void setParalysisDmg(Integer paralysisDmg) {
        ParalysisDmg = paralysisDmg;
    }

    public Integer getNumberOfHit() {
        return numberOfHit;
    }

    public void setNumberOfHit(Integer numberOfHit) {
        this.numberOfHit = numberOfHit;
    }

    public void fight (Player enemy) {
        int backstabDmg = 0;
        int paralysisDmg = 0;
        backstabDmg = backstab();
        paralysisDmg = Paralysis(enemy);
        if (enemy instanceof Wizard) {
            Wizard wizard = (Wizard) enemy;
            this.backstabDmg = backstabDmg;
            this.ParalysisDmg = paralysisDmg;
            backstabDmg = Math.round(backstabDmg + backstabDmg * 0.25f);
            paralysisDmg = Math.round(paralysisDmg + paralysisDmg * 0.25f);
            enemy.setDot(paralysisDmg);
           // System.out.println("DMG DEALT: " + backstabDmg);
           // System.out.println("PARALDMG DEALT: " + paralysisDmg);
            this.setFight(true);
            if (!wizard.isFight()) {
                wizard.fight(this);
            }

        } else if (enemy instanceof Knight) {
            System.out.println("ROGUE VS KNIGHT");
            Knight knight = (Knight) enemy;
            backstabDmg = Math.round(backstabDmg * (-0.1f));
            paralysisDmg = Math.round(paralysisDmg * (0.2f));
        } else if (enemy instanceof Rogue) {
            System.out.println("ROGUE VS ROGUE");
            Rogue rogue = (Rogue) enemy;
            backstabDmg = Math.round(backstabDmg + backstabDmg * 0.2f);
            paralysisDmg = Math.round(paralysisDmg + paralysisDmg * (-0.1f));
            enemy.setDot(paralysisDmg);
            this.setFight(true);
            if (!rogue.isFight()) {
                rogue.fight(this);
            }
        } else if (enemy instanceof Pyromancer) {
            System.out.println("ROGUE VS PYROMANCER");
            Pyromancer pyromancer = (Pyromancer) enemy;
            backstabDmg = Math.round(backstabDmg * 0.25f);
            paralysisDmg = Math.round(paralysisDmg * 0.2f);
        }
        if (enemy.getHp() - backstabDmg - paralysisDmg <= 0) {
            enemy.setHp(0);
            this.setXp(this.getXp() + Math.max(0, 200 - (this.getLevel() - enemy.getLevel())*40));
        } else {
            enemy.setHp(enemy.getHp() - backstabDmg - paralysisDmg);
        }
        enemy.setDot(paralysisDmg);
        enemy.setNrOfRoundsDOT(enemy.getNrOfRoundsDOT() - 1);
    }

    public int backstab() {
        this.setDmg(200 + 20 * this.getLevel());
        if (this.getTerrain().equals('W')) {
            this.setDmg(Math.round(this.getDmg() + this.getDmg() * 0.15f));
            if (numberOfHit % 3 == 0) {
                this.setDmg(Math.round(this.getDmg() * 1.5f));
            }
            numberOfHit++;
        } else {
            numberOfHit++;
        }
        return this.getDmg();
    }

    public int Paralysis(Player enemy) {
        int paralysisDmg = 40 + 10*this.getLevel();
        enemy.setNrOfRoundsDOT(3);
        if (this.getTerrain().equals('W')) {
            paralysisDmg = Math.round(paralysisDmg + paralysisDmg * 0.15f);
            enemy.setNrOfRoundsDOT(6);
        }
        this.setDmg(this.getDmg() + paralysisDmg);
        return paralysisDmg;
    }
}
