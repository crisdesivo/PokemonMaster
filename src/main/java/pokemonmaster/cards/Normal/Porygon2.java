package pokemonmaster.cards.Normal;

import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.IntermediateEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.EvolveActionCombat;
import pokemonmaster.util.CardInfo;

import java.util.function.Predicate;

import static pokemonmaster.CustomTags.POKEMON;
import static pokemonmaster.PokemonMasterMod.makeID;

public class Porygon2 extends IntermediateEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Porygon2",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);



    public Porygon2() {
        super(cardInfo,new PorygonZ(),CustomTags.NORMAL);


        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillNormal.png","pokemonmaster/character/cardback/bg_skillNormal_p.png");
        setCostUpgrade(0);
    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {

        addToBot(new SelectCardsInHandAction(p.hand.size(), "choose card to evolve",false,false, (Predicate<AbstractCard>) card -> card.hasTag(POKEMON), abstractCards -> {
            for (AbstractCard i : abstractCards) {
                addToBot(new EvolveActionCombat(i, AbstractDungeon.player.hand));
            }
        }));


    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Porygon2();
    }
}

