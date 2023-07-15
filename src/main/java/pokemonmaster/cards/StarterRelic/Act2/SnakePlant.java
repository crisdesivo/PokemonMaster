package pokemonmaster.cards.StarterRelic.Act2;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.SnakePlantPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class SnakePlant extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "SnakePlant",
            2,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);


    private static final int MAGIC = 3;


    public SnakePlant() {
        super(cardInfo);
        setInnate(false,true);
        setMagic(MAGIC);
        }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

            addToBot(new ApplyPowerAction(p, AbstractDungeon.player, new SnakePlantPower(p,magicNumber)));

        }


    @Override
    public AbstractCard makeCopy() { //Optional
        return new SnakePlant();
    }
}

