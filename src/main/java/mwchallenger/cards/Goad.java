package mwchallenger.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import mwchallenger.character.MyCharacter;
import mwchallenger.powers.ProvokePower;
import mwchallenger.util.CardStats;

public class Goad extends BaseCard{
    public static final String ID = makeID(Goad.class.getSimpleName());
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            1);
    public Goad() {
        super(ID, info);
        setDamage(9,11);
        setMagic(3);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m,new DamageInfo(p,this.damage,DamageInfo.DamageType.NORMAL)));
        if(m.getIntentBaseDmg() > 0) {// add if statement for attack intention
            addToBot(new ApplyPowerAction(m, p, new ProvokePower(m, this.magicNumber), this.magicNumber));
        }
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new Goad();
    }
}
