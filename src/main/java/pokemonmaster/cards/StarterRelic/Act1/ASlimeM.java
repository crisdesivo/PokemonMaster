package pokemonmaster.cards.StarterRelic.Act1;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class ASlimeM extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "ASlimeM",
            2,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 10;
    private static final int UPG_DAMAGE = 3;
    private static final int WEAKEN = 2;
    private static final int UPG_WEAKEN = 1;


    public ASlimeM() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(WEAKEN, UPG_WEAKEN);
        tags.add(CustomTags.BAIT);
        this.misc=35;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new ApplyPowerAction(m, AbstractDungeon.player, new WeakPower(p, magicNumber, false), magicNumber));

            }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new ASlimeM();
    }
}

