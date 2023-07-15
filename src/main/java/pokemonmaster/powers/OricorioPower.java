package pokemonmaster.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.status.Burn;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

import static pokemonmaster.PokemonMasterMod.makeID;

public class OricorioPower extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("OricorioPower");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = true;

    public OricorioPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }{
        this.isTurnBased = true;
        this.priority = 99;

    }
    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        if (this.amount >= 999)
            this.amount = 999;
    }
      public void updateDescription() {
      this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1]+this.amount + DESCRIPTIONS[2];
    }

    public void onEnergyRecharge() {
        addToBot(new ApplyPowerAction(owner, owner, new StrengthPower(owner,amount)));
        addToBot(new MakeTempCardInHandAction(new Burn(), amount));

    }




    @Override
    public AbstractPower makeCopy() {
        return new OricorioPower(owner, amount);
    }
}