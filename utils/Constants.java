package utils;

public final class Constants {
    private final Integer baseHpRogue = 600;
    private final Integer hpRoguePerLevel = 40;
    private final Integer baseHpWizard = 400;
    private final Integer hpWizardPerLevel = 30;
    private final Integer baseHpKnight = 900;
    private final Integer hpKnightPerLevel = 80;
    private final Integer baseHpPyromancer = 500;
    private final Integer hpPyromancerPerLevel = 50;
    private final Integer xpLevelUp = 250;
    private final Integer xpMultiplierLevel = 50;
    private final Integer criticalStrikeNumber = 3;
    private final Integer backstabDmg = 200;
    private final Integer backstabDmgPerLevel = 20;
    private final Integer winnerXP = 200;
    private final Integer winnerXpMultiplier = 40;
    private final Integer paralysisDmg = 40;
    private final Integer paralysisDmgPerLevel = 10;
    private final Integer paralysisRoundsExtended = 6;
    private final Integer paralysisRounds = 3;
    private final Integer igniteBaseDmg = 150;
    private final Integer igniteDmgPerLevel = 20;
    private final Integer igniteDOT = 50;
    private final Integer igniteDOTPerLevel = 30;
    private final Integer igniteRounds = 2;
    private final Integer fireblastDmg = 350;
    private final Integer fireblastDmgPerLevel = 50;
    private final Integer slamDmg = 100;
    private final Integer slamDmgPerLevel = 40;
    private final Integer executeDmg = 200;
    private final Integer executeDmgPerLevel = 30;
    private final Float maxProcent = 0.7f;
    private final Float deflectBaseProcent = 0.35f;
    private final Float deflectProcentPerLevel = 0.02f;
    private final Float drainBonusTerrain = 0.1f;
    private final Float baseDrainProcent = 0.2f;
    private final Float drainProcentPerLevel = 0.05f;
    private final Float minProcentMultiplier = 0.3f;
    private final Float wizardDrainMultiplier = 0.05f;
    private final Float pyromancerDrainMultiplier = 0.1f;
    private final Float knightDrainMultiplier = 0.2f;
    private final Float rogueDrainMultiplier = 0.2f;
    private final Float pyromancerMultiplierDeflect = 1.3f;
    private final Float knightMultiplierDeflect = 0.4f;
    private final Float rogueMultiplierDeflect = 0.2f;
    private final Float rogueBonusTerrain = 0.15f;
    private final Float criticalHit = 1.5f;
    private final Float pyroBackstabMultiplier = 0.25f;
    private final Float pyroParalysisMultiplier = 0.2f;
    private final Float rogueBackstabMultiplier = 0.2f;
    private final Float rogueParalysisMultiplier = -0.1f;
    private final Float knightBackstabMultiplier = -0.1f;
    private final Float knightParalysisMultiplier = 0.2f;
    private final Float wizardBackstabMultiplier = 0.25f;
    private final Float wizardParalysisMultiplier = 0.25f;
    private final Float pyroBonusTerrain = 1.25f;
    private final Float rogueIgnite = 0.8f;
    private final Float wizardIgnite = 1.05f;
    private final Float knightIgnite = 1.2f;
    private final Float pyroIgnite = 0.9f;
    private final Float knightFireblast = 1.2f;
    private final Float pyroFireblast = 0.9f;
    private final Float rogueFireblast = 0.8f;
    private final Float wizardFireblast = 1.05f;
    private final Float knightBonusTerrain = 0.15f;
    private final Float pyroSlam = 0.1f;
    private final Float pyroExecute = 1.1f;
    private final Float knightSlam = 0.2f;
    private final Float wizardSlam = 0.05f;
    private final Float wizardExecute = 0.2f;
    private final Float rogueSlam = 0.2f;
    private final Float rogueExecute = 0.15f;

    public Float getPyroSlam() {
        return pyroSlam;
    }

    public Float getPyroExecute() {
        return pyroExecute;
    }

    public Float getKnightSlam() {
        return knightSlam;
    }

    public Float getWizardSlam() {
        return wizardSlam;
    }

    public Float getWizardExecute() {
        return wizardExecute;
    }

    public Float getRogueSlam() {
        return rogueSlam;
    }

    public Float getRogueExecute() {
        return rogueExecute;
    }

    public Integer getSlamDmg() {
        return slamDmg;
    }

    public Integer getSlamDmgPerLevel() {
        return slamDmgPerLevel;
    }

    public Integer getExecuteDmg() {
        return executeDmg;
    }

    public Integer getExecuteDmgPerLevel() {
        return executeDmgPerLevel;
    }

    public Float getKnightBonusTerrain() {
        return knightBonusTerrain;
    }

    public Integer getFireblastDmg() {
        return fireblastDmg;
    }

    public Integer getFireblastDmgPerLevel() {
        return fireblastDmgPerLevel;
    }

    public Float getKnightFireblast() {
        return knightFireblast;
    }

    public Float getPyroFireblast() {
        return pyroFireblast;
    }

    public Float getRogueFireblast() {
        return rogueFireblast;
    }

    public Float getWizardFireblast() {
        return wizardFireblast;
    }

    public Integer getIgniteBaseDmg() {
        return igniteBaseDmg;
    }

    public Integer getIgniteDmgPerLevel() {
        return igniteDmgPerLevel;
    }

    public Integer getIgniteDOT() {
        return igniteDOT;
    }

    public Integer getIgniteDOTPerLevel() {
        return igniteDOTPerLevel;
    }

    public Integer getIgniteRounds() {
        return igniteRounds;
    }

    public Float getPyroBonusTerrain() {
        return pyroBonusTerrain;
    }

    public Float getRogueIgnite() {
        return rogueIgnite;
    }

    public Float getWizardIgnite() {
        return wizardIgnite;
    }

    public Float getKnightIgnite() {
        return knightIgnite;
    }

    public Float getPyroIgnite() {
        return pyroIgnite;
    }

    public Float getRogueBackstabMultiplier() {
        return rogueBackstabMultiplier;
    }

    public Float getRogueParalysisMultiplier() {
        return rogueParalysisMultiplier;
    }

    public Float getKnightBackstabMultiplier() {
        return knightBackstabMultiplier;
    }

    public Float getKnightParalysisMultiplier() {
        return knightParalysisMultiplier;
    }

    public Float getWizardBackstabMultiplier() {
        return wizardBackstabMultiplier;
    }

    public Float getWizardParalysisMultiplier() {
        return wizardParalysisMultiplier;
    }

    public Float getPyroBackstabMultiplier() {
        return pyroBackstabMultiplier;
    }

    public Float getPyroParalysisMultiplier() {
        return pyroParalysisMultiplier;
    }

    public Integer getBackstabDmg() {
        return backstabDmg;
    }

    public Integer getBackstabDmgPerLevel() {
        return backstabDmgPerLevel;
    }

    public Float getCriticalHit() {
        return criticalHit;
    }

    public Integer getCriticalStrikeNumber() {
        return criticalStrikeNumber;
    }

    public Integer getParalysisDmg() {
        return paralysisDmg;
    }

    public Integer getParalysisDmgPerLevel() {
        return paralysisDmgPerLevel;
    }

    public Float getRogueBonusTerrain() {
        return rogueBonusTerrain;
    }

    public Integer getParalysisRounds() {
        return paralysisRounds;
    }

    public Integer getParalysisRoundsExtended() {
        return paralysisRoundsExtended;
    }

    public Float getPyromancerMultiplierDeflect() {
        return pyromancerMultiplierDeflect;
    }

    public Float getKnightMultiplierDeflect() {
        return knightMultiplierDeflect;
    }

    public Float getRogueMultiplierDeflect() {
        return rogueMultiplierDeflect;
    }

    public Integer getWinnerXP() {
        return winnerXP;
    }

    public Integer getWinnerXpMultiplier() {
        return winnerXpMultiplier;
    }

    public Float getRogueDrainMultiplier() {
        return rogueDrainMultiplier;
    }

    public Float getKnightDrainMultiplier() {
        return knightDrainMultiplier;
    }

    public Float getPyromancerDrainMultiplier() {
        return pyromancerDrainMultiplier;
    }

    public Float getWizardDrainMultiplier() {
        return wizardDrainMultiplier;
    }

    public Float getDrainBonusTerrain() {
        return drainBonusTerrain;
    }

    public Float getBaseDrainProcent() {
        return baseDrainProcent;
    }

    public Float getDrainProcentPerLevel() {
        return drainProcentPerLevel;
    }

    public Float getMinProcentMultiplier() {
        return minProcentMultiplier;
    }

    public Float getMaxProcent() {
        return maxProcent;
    }

    public Float getDeflectBaseProcent() {
        return deflectBaseProcent;
    }

    public Float getDeflectProcentPerLevel() {
        return deflectProcentPerLevel;
    }

    public Integer getBaseHpRogue() {
        return baseHpRogue;
    }

    public Integer getHpRoguePerLevel() {
        return hpRoguePerLevel;
    }

    public Integer getBaseHpWizard() {
        return baseHpWizard;
    }

    public Integer getHpWizardPerLevel() {
        return hpWizardPerLevel;
    }

    public Integer getBaseHpKnight() {
        return baseHpKnight;
    }

    public Integer getHpKnightPerLevel() {
        return hpKnightPerLevel;
    }

    public Integer getBaseHpPyromancer() {
        return baseHpPyromancer;
    }

    public Integer getHpPyromancerPerLevel() {
        return hpPyromancerPerLevel;
    }

    public Integer getXpLevelUp() {
        return xpLevelUp;
    }

    public Integer getXpMultiplierLevel() {
        return xpMultiplierLevel;
    }
}
