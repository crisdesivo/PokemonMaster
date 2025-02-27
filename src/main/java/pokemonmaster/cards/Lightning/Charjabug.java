package pokemonmaster.cards.Lightning;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.IntermediateEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Spark;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Charjabug extends IntermediateEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Charjabug",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 4;
    private static final int SPARK = 2;
    private static final int UPG_SPARK= 1;



    public Charjabug() {
        super(cardInfo,new Vikavolt(),CustomTags.LIGHTNING);
        setDamage(DAMAGE);
        setMagic(SPARK, UPG_SPARK);
        tags.add(CustomTags.BAIT);
        this.misc = 60;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackLightning.png","pokemonmaster/character/cardback/bg_attackLightning_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {

        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new ApplyPowerAction(p, p, new Spark(p, magicNumber)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Charjabug();
    }
}

