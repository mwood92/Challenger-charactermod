package mwchallenger.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.UIStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.vfx.ThoughtBubble;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class GoadAction extends AbstractGameAction {
    //private static final UIStrings uiStrings;
    //public static final String[] TEXT;
    private int damageIncrease;
    private AbstractMonster targetMonster;

    public GoadAction(int damageIncrease, AbstractMonster m) {
        this.duration = 0.0F;
        this.actionType = AbstractGameAction.ActionType.WAIT;
        this.damageIncrease = damageIncrease;
        this.targetMonster = m;
    }

    public void update() {
        if (this.targetMonster != null && this.targetMonster.getIntentBaseDmg() >= 0) {
            this.targetMonster.setIntentBaseDmg(this.targetMonster.getIntentBaseDmg()+damageIncrease);
            this.targetMonster.applyPowers();
        }

        this.isDone = true;
    }
}
