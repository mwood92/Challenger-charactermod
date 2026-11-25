package mwchallenger.cards.common;

import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.ThornsPower;
import mwchallenger.cards.BaseCard;
import mwchallenger.character.MyCharacter;
import mwchallenger.util.CardStats;

public class BrambleStrike extends BaseCard {
    public static final String ID = makeID(BrambleStrike.class.getSimpleName());
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            1);

    public BrambleStrike() {
        super(ID, info);
        setDamage(8, 2);
        setCustomVar("thorns", 0);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, this.damage, DamageInfo.DamageType.NORMAL)));

        AbstractPower thorns = p.getPower(ThornsPower.POWER_ID);

        if (thorns != null && thorns.amount > 0) {
            setCustomVar("thorns", thorns.amount);
            addToBot(new DamageAction(m, new DamageInfo(p, thorns.amount, DamageInfo.DamageType.NORMAL)));
        }
    }
}