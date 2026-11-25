package mwchallenger.cards.common;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;
import mwchallenger.cards.BaseCard;
import mwchallenger.character.MyCharacter;
import mwchallenger.powers.CounterPower;
import mwchallenger.util.CardStats;

public class Discombobulate extends BaseCard {
    public static final int DAMAGE = 9;
    public static final int UPG_DAMAGE = 3;
    public static final int MAGICNUMBER = 1;
    public static final int UPG_MAGICNUMBER = 1;

    public static final String ID = makeID(Discombobulate.class.getSimpleName());
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            1
    );
    public Discombobulate() {
        super(ID, info);
        setDamage(DAMAGE,UPG_DAMAGE);
        setMagic(MAGICNUMBER,UPG_MAGICNUMBER);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.applyPowers();
        addToBot(new DamageAction(m, new DamageInfo(p, this.damage, DamageInfo.DamageType.NORMAL)));
        if (AbstractDungeon.player.hasPower(makeID(CounterPower.class.getSimpleName()))) {
            addToBot(new ApplyPowerAction(m, p, new WeakPower(p, this.magicNumber, false)));
        }
    }
}
