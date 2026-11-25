package mwchallenger.cards.uncommon;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import mwchallenger.actions.CornerAction;
import mwchallenger.cards.BaseCard;
import mwchallenger.character.MyCharacter;
import mwchallenger.powers.ParryPower;
import mwchallenger.util.CardStats;

public class Corner extends BaseCard {
    public static final String ID = makeID(Corner.class.getSimpleName());
    public static final int BLOCK = 7;
    public static final int UPG_BLOCK = 3;
    public static final int MAGICNUMBER = 1;
    public static final int UPG_MAGICNUMBER = 1;

    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.UNCOMMON,
            CardTarget.SELF,
            1
    );
    public Corner() {
        super(ID, info);
        setBlock(BLOCK,UPG_BLOCK);
        setMagic(MAGICNUMBER,UPG_MAGICNUMBER);

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new CornerAction(p,this.magicNumber));
        addToBot(new GainBlockAction(p,block));
        addToBot(new ApplyPowerAction(p,p,new ParryPower(p)));
    }
}
