package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.status.Wound;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static pokemonmaster.PokemonMasterMod.makeID;

public class WoundedPower extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("WoundedPower");
    private static final PowerType TYPE = PowerType.DEBUFF;
    private static final boolean TURN_BASED = true;

    public WoundedPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }{
        this.isTurnBased = true;
        this.priority = 1000;

    }
    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        if (this.amount >= 2)
            this.amount = 1;
    }
      public void updateDescription() {
      this.description = DESCRIPTIONS[0];
    }

    public void atStartOfTurn() {
        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInHandAction(new Wound(),7));
        addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, this));

    }


    @Override
    public AbstractPower makeCopy() {
        return new WoundedPower(owner, amount);
    }
}