package mwchallenger.cards.uncommon;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import mwchallenger.cards.BaseCard;
import mwchallenger.cards.starter.Parry;
import mwchallenger.character.MyCharacter;
import mwchallenger.powers.CounterPower;
import mwchallenger.util.CardStats;

public class BeFirst extends BaseCard {
    public static final String ID = makeID(BeFirst.class.getSimpleName());
    public static final int DAMAGE = 9;
    public static final int UPG_DAMAGE = 3;
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.UNCOMMON,
            CardTarget.ENEMY,
            1
    );

    public BeFirst() {
        super(ID, info);
        setDamage(DAMAGE,UPG_DAMAGE);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m,new DamageInfo(p, this.damage, DamageInfo.DamageType.NORMAL)));
        if(AbstractDungeon.actionManager.cardsPlayedThisTurn.size()==1){
            addToBot(new ApplyPowerAction(p,p,new CounterPower(p)));
        }

    }
}
