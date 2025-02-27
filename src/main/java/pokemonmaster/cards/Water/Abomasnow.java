package pokemonmaster.cards.Water;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Barrier;
import pokemonmaster.powers.HailPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Abomasnow extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Abomasnow",
            1,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 4;
    private static final int UPG_MAGIC= 3;



    public Abomasnow() {
        super(cardInfo,CustomTags.WATER);
        setMagic(MAGIC,UPG_MAGIC);


        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerWater.png","pokemonmaster/character/cardback/bg_powerWater_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new HailPower(p, magicNumber)));
        addToBot(new ApplyPowerAction(p, p, new Barrier(p, 4)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Abomasnow();
    }
}

