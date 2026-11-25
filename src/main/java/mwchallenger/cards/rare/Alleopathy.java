package mwchallenger.cards.rare;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import mwchallenger.cards.BaseCard;
import mwchallenger.character.MyCharacter;
import mwchallenger.powers.AlleopathyPower;
import mwchallenger.util.CardStats;

public class Alleopathy extends BaseCard {
    public static final int MAGICNUMBER = 2;
    public static final int UPG_MAGICNUMBER = 1;

    public static final String ID = makeID(Alleopathy.class.getSimpleName());
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.POWER,
            CardRarity.RARE,
            CardTarget.SELF,
            3
    );
    public Alleopathy() {
        super(ID, info);
        setMagic(MAGICNUMBER,UPG_MAGICNUMBER);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p,p,new AlleopathyPower(p,magicNumber),1));

    }
}
