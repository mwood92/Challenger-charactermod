package mwchallenger.cards.rare;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import mwchallenger.actions.ExfoliateAction;
import mwchallenger.cards.BaseCard;
import mwchallenger.character.MyCharacter;
import mwchallenger.util.CardStats;

public class Exfoliate extends BaseCard {
    public static final String ID = makeID(Exfoliate.class.getSimpleName());
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.RARE,
            CardTarget.SELF,
            -1);
    public Exfoliate() {
        super(ID, info);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster abstractMonster) {
        addToBot(new ExfoliateAction(p,energyOnUse));
    }
}
