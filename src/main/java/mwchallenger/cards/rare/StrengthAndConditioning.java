package mwchallenger.cards.rare;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import mwchallenger.cards.BaseCard;
import mwchallenger.cards.starter.OneTwo;
import mwchallenger.character.MyCharacter;
import mwchallenger.powers.StrengthAndConditioningPower;
import mwchallenger.util.CardStats;

public class StrengthAndConditioning extends BaseCard {

    public static final String ID = makeID(StrengthAndConditioning.class.getSimpleName());
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.POWER,
            CardRarity.RARE,
            CardTarget.SELF,
            2
    );
    public StrengthAndConditioning() {
        super(ID, info);
        setMagic(5,2);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p,p,new StrengthAndConditioningPower(p,this.magicNumber),0));

    }
}
