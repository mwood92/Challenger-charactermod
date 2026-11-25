package mwchallenger.cards.uncommon;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import mwchallenger.cards.BaseCard;
import mwchallenger.cards.starter.OneTwo;
import mwchallenger.character.MyCharacter;
import mwchallenger.powers.BarkChinPower;
import mwchallenger.powers.RallyPower;
import mwchallenger.util.CardStats;

public class Rally extends BaseCard {
    public static final int MAGICNUMBER = 2;
    public static final int UPG_MAGICNUMBER = 3;

    public static final String ID = makeID(Rally.class.getSimpleName());
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.POWER,
            CardRarity.UNCOMMON,
            CardTarget.SELF,
            2
    );
    public Rally() {
        super(ID, info);
        setMagic(MAGICNUMBER,UPG_MAGICNUMBER);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p,m,new RallyPower(p,this.magicNumber)));
    }
}
