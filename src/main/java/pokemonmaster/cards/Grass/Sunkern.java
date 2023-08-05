package pokemonmaster.cards.Grass;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Sunkern extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Sunkern",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 5;
    private static final int UPG_BLOCK= 3;
    private static final int MAGIC = 1;



    public Sunkern() {
        super(cardInfo,new Sunflora(), new Sunflora(), CustomTags.GRASS);
        setBlock(BLOCK, UPG_BLOCK);
        setMagic(MAGIC);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillGrass.png","pokemonmaster/character/cardback/bg_skillGrass_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {

        addToBot(new GainBlockAction(p, p, block));

        for(AbstractCard l : p.hand.group){
            if (l.type==CardType.STATUS){
                addToBot(new HealAction(p,p,magicNumber));
            }
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Sunkern();
    }
}

