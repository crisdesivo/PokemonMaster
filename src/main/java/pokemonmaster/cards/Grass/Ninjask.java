package pokemonmaster.cards.Grass;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.NinjaskPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Ninjask extends BaseCard {




    private final static CardInfo cardInfo = new CardInfo(
            "Ninjask",
            2,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int NINBUF = 1;



    public Ninjask() {
        super(cardInfo);
        tags.add(CustomTags.GRASS);
        tags.add(CustomTags.EVOLVED);
        tags.add(CustomTags.POKEMON);
        setMagic(NINBUF);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_powerGrass.png","pokemonmaster/character/cardback/bg_powerGrass_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new ApplyPowerAction(p, p, new NinjaskPower(p,magicNumber)));
    }


    @Override
    public AbstractCard makeCopy() { //Optional
        return new Ninjask();
    }
}

