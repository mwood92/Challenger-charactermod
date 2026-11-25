package mwchallenger.cards.uncommon;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import mwchallenger.cards.BaseCard;
import mwchallenger.cards.common.NewLeaf;
import mwchallenger.character.MyCharacter;
import mwchallenger.powers.CambiumPower;
import mwchallenger.util.CardStats;

public class Cambium extends BaseCard {
    public static final String ID = makeID(Cambium.class.getSimpleName());
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.POWER,
            CardRarity.UNCOMMON,
            CardTarget.SELF,
            2
    );

    public Cambium() {
        super(ID,info);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p,p,new CambiumPower(p,5,2)));

    }
}
