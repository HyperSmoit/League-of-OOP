public class Wizard extends Player{


    public Wizard() {
        super();
        this.setInitialHp(400 + 30 * this.getLevel());
        this.setHp(this.getInitialHp());
    }

    public void fight(Player enemy) {
        if (enemy instanceof Rogue) {
            Rogue rogue = (Rogue) enemy;
            int drainDmg = drain(rogue);
            int deflectDmg = deflect(rogue);
            deflectDmg = Math.round(deflectDmg + deflectDmg * 0.2f);
            if (this.getTerrain().equals('D')) {
                deflectDmg += Math.round(deflectDmg * 0.1f);
            }
            rogue.setHp(rogue.getHp() - drainDmg - deflectDmg);

            this.setFight(true);
            if (!rogue.isFight()) {
                rogue.fight(this);
            }
        } else if (enemy instanceof Wizard) {
            Wizard wizard = (Wizard) enemy;
            int drainDmg = drain(wizard);
            wizard.setHp(wizard.getHp() - drainDmg);
        }
    }

    public int drain(Rogue rogue) {
        float procent = 0.2f + 0.05f * this.getLevel();
        int dmg = Math.round((procent - (0.2f * procent)) * Math.min(0.3f * rogue.getInitialHp(), rogue.getHp()));
        if (this.getTerrain().equals('D')) {
            dmg = Math.round(dmg + dmg * 0.1f);
        }
    return dmg;
    }

    public int drain(Knight knight) {
        int dmg = Math.round((0.2f + 0.05f * this.getLevel() + (0.2f * (0.2f + 0.05f * this.getLevel()))) * Math.min(0.3f * knight.getInitialHp(), knight.getHp()));
        if (this.getTerrain().equals('D')) {
            dmg = Math.round(dmg + dmg * 0.1f);
        }
        return dmg;
    }

    public int drain(Pyromancer pyromancer) {
        int dmg = Math.round((0.2f + 0.05f * this.getLevel() - (0.1f * (0.2f + 0.05f * this.getLevel()))) * Math.min(0.3f * pyromancer.getInitialHp(), pyromancer.getHp()));
        if (this.getTerrain().equals('D')) {
            dmg = Math.round(dmg + dmg * 0.1f);
        }
        return dmg;
    }

    public int drain(Wizard wizard) {
        int dmg = Math.round((0.2f + 0.05f * this.getLevel() + (0.05f * (0.2f + 0.05f * this.getLevel()))) * Math.min(0.3f * wizard.getInitialHp(), wizard.getHp()));
        if (this.getTerrain().equals('D')) {
            dmg = Math.round(dmg + dmg * 0.1f);
        }
        return dmg;
    }

    public int deflect(Rogue rogue) {
        int deflectDmg;
        float procent = 0.35f + 0.2f * this.getLevel();
        if (procent > 0.7f)
            procent = 0.7f;
        deflectDmg = Math.round((rogue.getBackstabDmg() + rogue.getParalysisDmg())* procent);
        return deflectDmg;
    }
}
