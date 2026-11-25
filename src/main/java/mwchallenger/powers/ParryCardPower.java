package mwchallenger.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.VulnerablePower;

import static mwchallenger.BasicMod.makeID;

public class ParryCardPower extends BasePower {
    public static final String Power_ID = makeID(ParryCardPower.class.getSimpleName());
    private static final PowerType TYPE = PowerType.BUFF;

    private static boolean TURN_TYPE = true;
    public static final String NAME = "Parry";
    private static final int turns = -1;
    public boolean parry_block_check = false;

    public ParryCardPower(AbstractCreature owner, int amount) {
        super(Power_ID, TYPE, TURN_TYPE, owner, turns);
        this.owner = owner;
        this.amount = amount;
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        if (AbstractDungeon.player.currentBlock > 0 & isPlayer) {
            parry_block_check = true;
        }
    }

    @Override
    public int onAttackedToChangeDamage(DamageInfo info, int damageAmount) {
        AbstractPlayer p = AbstractDungeon.player;
        com.megacrit.cardcrawl.core.AbstractCreature target = info.owner;
        if(p.currentBlock == 0 & parry_block_check){
            this.addToTop(new ApplyPowerAction(target,p,new VulnerablePower(target,amount,false)));
            this.addToTop(new RemoveSpecificPowerAction(p,p,ID));
        }
        return super.onAttackedToChangeDamage(info, damageAmount);
    }

    @Override
    public void atEndOfRound() {
        AbstractPlayer p = AbstractDungeon.player;
        this.addToTop(new RemoveSpecificPowerAction(p,p,ID));
        super.atEndOfRound();
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1];
    }
}
