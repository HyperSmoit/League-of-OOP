package main;
public class Pyromancer extends Player{
    private Integer fireblastDmg;
    private Integer igniteDmg;
    public Pyromancer() {
        super();
        super.setInitialHp(500 + 50 * this.getLevel());
        this.setHp(this.getInitialHp());
    }

    public Integer getFireblastDmg() {
        return fireblastDmg;
    }

    public void setFireblastDmg(Integer fireblastDmg) {
        this.fireblastDmg = fireblastDmg;
    }

    public Integer getIgniteDmg() {
        return igniteDmg;
    }

    public void setIgniteDmg(Integer igniteDmg) {
        this.igniteDmg = igniteDmg;
    }

    public void fight(Player enemy) {
        int fireblastDmg = fireblast();
        int igniteDmg = ignite(enemy);

        if (enemy instanceof Rogue) {
            Rogue rogue = (Rogue) enemy;
            fireblastDmg = Math.round(fireblastDmg - fireblastDmg * 0.2f);
            igniteDmg = Math.round(igniteDmg - igniteDmg * 0.2f);
            this.setFight(true);
            if (!rogue.isFight()) {
                rogue.fight(this);
            }

        } else if (enemy instanceof Wizard) {
            Wizard wizard = (Wizard) enemy;
            this.fireblastDmg = fireblastDmg;
            this.igniteDmg = igniteDmg;
            fireblastDmg = Math.round(fireblastDmg + fireblastDmg * 0.05f);
            igniteDmg = Math.round(igniteDmg + igniteDmg * 0.05f);
            this.setFight(true);
            if (!wizard.isFight()) {
                wizard.fight(this);
            }
        } else if (enemy instanceof Knight) {
            Knight knight = (Knight) enemy;
            fireblastDmg = fireblast(knight);
            //igniteDmg = Math.round(igniteDmg * 1.2f);
            System.out.println(fireblastDmg);
            System.out.println(igniteDmg);
            this.setFight(true);
            if (!knight.isFight()) {
                knight.fight(this);
            }
        } else if (enemy instanceof Pyromancer) {
            Pyromancer pyromancer = (Pyromancer) enemy;
            fireblastDmg = Math.round(fireblastDmg - fireblastDmg * 0.1f);
            igniteDmg = Math.round(igniteDmg - igniteDmg * 0.1f);
            this.setFight(true);
            if (!pyromancer.isFight()) {
                pyromancer.fight(this);
            }
        }

        if (enemy.getHp() - fireblastDmg - igniteDmg <= 0) {
            enemy.setHp(0);
            this.setXp(this.getXp() + Math.max(0, 200 - (this.getLevel() - enemy.getLevel())*40));
        } else {
            enemy.setHp(enemy.getHp() - fireblastDmg - igniteDmg);
        }

        enemy.setNrOfRoundsDOT(enemy.getNrOfRoundsDOT() - 1);

    }

    public int fireblast() {
        int baseDmg = 350 + 50 * this.getLevel();
        if (this.getTerrain().equals('V')) {
            baseDmg = Math.round(baseDmg * 1.25f);
        }
        return baseDmg;
    }
    public int fireblast(Knight knight) {
        int baseDmg = 350 + 50 * this.getLevel();
        baseDmg = Math.round(baseDmg * 1.2f);
        if (this.getTerrain().equals('V')) {
            baseDmg = Math.round(baseDmg * 1.25f);
        }
        return baseDmg;
    }

    public int ignite(Player enemy) {
        int baseDmg = 150 + 20 * this.getLevel();
        int baseDOT = 50 + 30 * this.getLevel();
        enemy.setNrOfRoundsDOT(2);
        if (enemy instanceof Rogue) {
            Rogue rogue = (Rogue) enemy;
            rogue.setDot(Math.round(0.8f * baseDOT));

        } else if (enemy instanceof Wizard) {
            Wizard wizard = (Wizard) enemy;
            wizard.setDot(Math.round(1.05f * baseDOT));

        } else if (enemy instanceof Knight) {
            Knight knight = (Knight) enemy;
            baseDmg = Math.round(baseDmg * 1.2f);
            knight.setDot(Math.round(1.2f * baseDOT));

        } else if (enemy instanceof Pyromancer) {
            Pyromancer pyromancer = (Pyromancer) enemy;
            pyromancer.setDot(Math.round(0.9f * baseDOT));
        }
        if (this.getTerrain().equals('V')) {
            baseDmg = Math.round(baseDmg * 1.25f);
            enemy.setDot(Math.round(enemy.getDot() * 0.25f));
        }
        return baseDmg;
    }
}
