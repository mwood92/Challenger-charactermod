package mwchallenger.cards.uncommon;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import mwchallenger.cards.BaseCard;
import mwchallenger.character.MyCharacter;
import mwchallenger.powers.CounterPower;
import mwchallenger.util.CardStats;

public class Counterpunch extends BaseCard {
    public static final String ID = makeID(Counterpunch.class.getSimpleName());
    public static final int DAMAGE = 12;
    public static final int UPG_DAMAGE = 6;
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.UNCOMMON,
            CardTarget.ENEMY,
            2
    );

    public Counterpunch() {
        super(ID, info);
        setDamage(DAMAGE,UPG_DAMAGE);
    }

    @Override
    public void applyPowers() {
        if(AbstractDungeon.player.hasPower(makeID(CounterPower.class.getSimpleName()))){
            this.cost = 0;
        }
        super.applyPowers();
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m,new DamageInfo(p, this.damage, DamageInfo.DamageType.NORMAL)));
    }
}
