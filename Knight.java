package main;
public class Knight extends Player {
    Integer slamDmg;
    Integer executeDmg;

    public Knight() {
        super();
        super.setInitialHp(900 + 80 * this.getLevel());
        this.setHp(this.getInitialHp());
    }

    public Integer getSlamDmg() {
        return slamDmg;
    }

    public void setSlamDmg(Integer slamDmg) {
        this.slamDmg = slamDmg;
    }

    public Integer getExecuteDmg() {
        return executeDmg;
    }

    public void setExecuteDmg(Integer executeDmg) {
        this.executeDmg = executeDmg;
    }

    public void fight(Player enemy) {
        int slamDmg = slam(enemy);
        int executeDmg = execute();
        if (enemy instanceof Rogue) {

            Rogue rogue = (Rogue) enemy;
            executeDmg = Math.round(executeDmg + executeDmg * 0.15f);
            slamDmg = Math.round(slamDmg - slamDmg * 0.2f);
            this.setFight(true);
            if (!rogue.isFight()) {
                rogue.fight(this);
            }
        } else if (enemy instanceof Wizard) {
            Wizard wizard = (Wizard) enemy;
            this.executeDmg = executeDmg;
            this.slamDmg = slamDmg;
//            System.out.println(executeDmg);
//            System.out.println(slamDmg);
            executeDmg = Math.round(executeDmg - executeDmg * 0.2f);
            slamDmg = Math.round(slamDmg + slamDmg * 0.05f);
//            System.out.println("AFTER AMPLIF:");
//            System.out.println(executeDmg);
//            System.out.println(slamDmg);
            this.setFight(true);
            if (!wizard.isFight()) {
                wizard.fight(this);
            }

        } else if (enemy instanceof Knight) {
            Knight knight = (Knight) enemy;
            slamDmg = Math.round(slamDmg + slamDmg * 0.2f);
            this.setFight(true);
            if (!knight.isFight()) {
                knight.fight(this);
            }

        } else if (enemy instanceof Pyromancer) {
            Pyromancer pyromancer = (Pyromancer) enemy;
            slamDmg = Math.round(slamDmg - slamDmg * 0.1f);
            executeDmg = Math.round(1.1f * executeDmg);
            this.setFight(true);
            if (!pyromancer.isFight()) {
                pyromancer.fight(this);
            }
        }
        if (enemy.getHp() - slamDmg - executeDmg <= 0) {
            enemy.setHp(0);
            this.setXp(this.getXp() + Math.max(0, 200 - (this.getLevel() - enemy.getLevel())*40));
        } else {
            enemy.setHp(enemy.getHp() - slamDmg - executeDmg);
        }

    }

    public int execute() {
        int baseDmg = 200 + 30 * this.getLevel();
        if (this.getTerrain().equals('L')) {
            return (baseDmg + Math.round(baseDmg * 0.15f));
        }
        return baseDmg;
    }

    public int slam(Player enemy) {
        int basedmg = 100 + 40 * this.getLevel();
        enemy.setStunnedRounds(1);
        enemy.setStunned(true);
        if (this.getTerrain().equals('L')) {
            return (basedmg + Math.round(basedmg * 0.15f));
        }
        return basedmg;
    }

}
