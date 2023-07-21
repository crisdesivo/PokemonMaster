package pokemonmaster.cards.Psychic;

import com.megacrit.cardcrawl.actions.common.InstantKillAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Unown extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Unown",
            2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);


    public Unown() {
        super(cardInfo);
        setCostUpgrade(1);
        tags.add(CustomTags.PSYCHIC);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.baseMagicNumber=0;

        this.isMagicNumberModified = this.baseMagicNumber != this.magicNumber;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillPsychic.png","pokemonmaster/character/cardback/bg_skillPsychic_p.png");
        this.rawDescription = cardStrings.DESCRIPTION;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (magicNumber >= 35){
            if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
                for (AbstractMonster monster : (AbstractDungeon.getMonsters()).monsters) {
                    if (!monster.isDead && !monster.isDying) {
                        addToBot(new InstantKillAction(monster));
                    }
                }
            }
        }


    }


    @Override
    public void applyPowers() {
        this.magicNumber= AbstractDungeon.actionManager.cardsPlayedThisTurn.size();
        this.isMagicNumberModified = this.baseMagicNumber != this.magicNumber;
        super.applyPowers();
        this.rawDescription = cardStrings.DESCRIPTION;
        this.rawDescription += cardStrings.EXTENDED_DESCRIPTION[0];
        this.initializeDescription();
    }
    public void calculateCardDamage(AbstractMonster mo) {
        this.magicNumber= AbstractDungeon.actionManager.cardsPlayedThisTurn.size();
        this.isMagicNumberModified = this.baseMagicNumber != this.magicNumber;
        super.calculateCardDamage(mo);
        this.rawDescription = cardStrings.DESCRIPTION;
        this.rawDescription += cardStrings.EXTENDED_DESCRIPTION[0];
        this.initializeDescription();
    }


    public void onMoveToDiscard() {
        this.rawDescription = cardStrings.DESCRIPTION;
        initializeDescription();
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Unown();
    }
}

