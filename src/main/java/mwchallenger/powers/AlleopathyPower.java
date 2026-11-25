package mwchallenger.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.PoisonPower;
import mwchallenger.actions.AlleopathyAction;

import static mwchallenger.BasicMod.makeID;

public class AlleopathyPower extends BasePower {
    public static final String Power_ID = makeID(AlleopathyPower.class.getSimpleName());
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_TYPE = false;
    public static final String NAME = "Alleopathy";
    private static final int turns = -1;

    public AlleopathyPower(AbstractCreature owner, int amount) {
        super(Power_ID, TYPE, TURN_TYPE, owner, amount);

    }

    @Override
    public int onAttacked(DamageInfo info, int damageAmount) {
        AbstractPlayer p = AbstractDungeon.player;
        if (damageAmount > 0 & info.owner != p) {
            addToBot(new ApplyPowerAction(p,p,new PoisonPower(p,p,1)));
            addToBot(new AlleopathyAction(p,info,amount));
        }
        return super.onAttacked(info, damageAmount);
    }
}
