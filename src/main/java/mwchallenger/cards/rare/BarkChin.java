package mwchallenger.cards.rare;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import mwchallenger.cards.BaseCard;
import mwchallenger.cards.starter.OneTwo;
import mwchallenger.character.MyCharacter;
import mwchallenger.powers.BarkChinPower;
import mwchallenger.util.CardStats;

public class BarkChin extends BaseCard {
    public static final int MAGICNUMBER = 1;
    public static final int UPG_MAGICNUMBER = 1;

    public static final String ID = makeID(BarkChin.class.getSimpleName());
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.POWER,
            CardRarity.RARE,
            CardTarget.SELF,
            2
    );
    public BarkChin() {
        super(ID, info);
        setMagic(MAGICNUMBER,UPG_MAGICNUMBER);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p,m,new BarkChinPower(p,this.magicNumber)));
    }
}
