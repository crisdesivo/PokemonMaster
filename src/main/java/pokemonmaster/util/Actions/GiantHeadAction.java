package pokemonmaster.util.Actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import pokemonmaster.cards.StarterRelic.Act3.GiantHead;

public class GiantHeadAction extends AbstractGameAction {
    private AbstractCard card;

    public GiantHeadAction(AbstractCard card, int amount) {
        this.card = card;
        this.amount = amount;
    }

    public void update() {
        this.card.baseDamage += this.amount;
        this.card.applyPowers();
        for (AbstractCard c : AbstractDungeon.player.discardPile.group) {
            if (c instanceof GiantHead) {
                c.baseDamage += this.amount;
                c.applyPowers();
            }
        }
        for (AbstractCard c : AbstractDungeon.player.drawPile.group) {
            if (c instanceof GiantHead) {
                c.baseDamage += this.amount;
                c.applyPowers();
            }
        }
        for (AbstractCard c : AbstractDungeon.player.hand.group) {
            if (c instanceof GiantHead) {
                c.baseDamage += this.amount;
                c.applyPowers();
            }
        }
        this.isDone = true;
    }
}