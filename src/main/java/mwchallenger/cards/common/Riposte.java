package mwchallenger.cards.common;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import mwchallenger.cards.BaseCard;
import mwchallenger.cards.starter.Parry;
import mwchallenger.character.MyCharacter;
import mwchallenger.powers.ParryCardPower;
import mwchallenger.powers.ParryPower;
import mwchallenger.powers.RipostePower;
import mwchallenger.util.CardStats;

public class Riposte extends BaseCard {
    public static final int DAMAGE = 9;
    public static final int UPG_DAMAGE = 0;
    public static final int MAGICNUMBER = 6;
    public static final int UPG_MAGICNUMBER = 4;


    public static final String ID = makeID(Riposte.class.getSimpleName());
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.BASIC,
            CardTarget.ENEMY,
            1
    );
    public Riposte() {
        super(ID, info);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGICNUMBER, UPG_MAGICNUMBER);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.applyPowers();
        addToBot(new DamageAction(m, new DamageInfo(p,this.damage, DamageInfo.DamageType.NORMAL)));
        this.addToBot(new ApplyPowerAction(p,p,new ParryPower(p)));
        this.addToBot(new ApplyPowerAction(p,p,new RipostePower(p,m,this.magicNumber)));
    }
}
