package mwchallenger.cards.uncommon;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import mwchallenger.cards.BaseCard;
import mwchallenger.cards.rare.Alleopathy;
import mwchallenger.character.MyCharacter;
import mwchallenger.powers.CankerPower;
import mwchallenger.powers.ParryPower;
import mwchallenger.powers.RipostePower;
import mwchallenger.util.CardStats;

public class Canker extends BaseCard {
    public static final int BLOCK = 5;
    public static final int UPG_BLOCK = 2;
    public static final int MAGICNUMBER = 2;
    public static final int UPG_MAGICNUMBER = 1;

    public static final String ID = makeID(Canker.class.getSimpleName());
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.POWER,
            CardRarity.UNCOMMON,
            CardTarget.SELF,
            1
    );

    public Canker() {
        super(ID, info);
        setBlock(BLOCK,UPG_BLOCK);
        setMagic(MAGICNUMBER,UPG_MAGICNUMBER);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p,block));
        this.addToBot(new ApplyPowerAction(p,p,new ParryPower(p)));
        this.addToBot(new ApplyPowerAction(p,p,new CankerPower(p,this.magicNumber)));

    }
}
