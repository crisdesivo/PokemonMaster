package pokemonmaster.cards.Fire;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Combusken extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Combusken",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 6;
    private static final int DAMAGEUP = 4;

    private static final int DEXUP = 2;


    public Combusken() {
        super(cardInfo);
        setDamage(DAMAGE,DAMAGEUP);
        setMagic(DEXUP);
        purgeOnUse = true;
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.FIRE);
        tags.add(CustomTags.EVOLVED);
        this.cardsToPreview = new Blaziken();
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackFire.png","pokemonmaster/character/cardback/bg_attackFire_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDiscardAction(new Blaziken(), 1));
        addToBot(new ApplyPowerAction(p, p, new DexterityPower(p,magicNumber)));


    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Combusken();
    }
}

