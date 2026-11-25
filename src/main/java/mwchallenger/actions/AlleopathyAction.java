package mwchallenger.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.powers.PoisonPower;

public class AlleopathyAction extends AbstractGameAction {
AbstractPlayer player;
DamageInfo info;

    public AlleopathyAction(AbstractPlayer player, DamageInfo info,int amount) {
        this.player = player;
        this.info = info;
        this.amount = amount;
        this.startDuration = Settings.ACTION_DUR_FAST;
    }

    @Override
    public void update() {
        if(player.hasPower(PoisonPower.POWER_ID) & startDuration != duration) {
            int apply_poison_amount = player.getPower(PoisonPower.POWER_ID).amount * amount;
            addToTop(new ApplyPowerAction(info.owner, player, new PoisonPower(info.owner, player, apply_poison_amount), apply_poison_amount));
        }
        this.tickDuration();

    }
}
