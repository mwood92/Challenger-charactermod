package mwchallenger.cards.rare;

import com.evacipated.cardcrawl.mod.stslib.powers.StunMonsterPower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import mwchallenger.cards.BaseCard;
import mwchallenger.cards.common.Riposte;
import mwchallenger.character.MyCharacter;
import mwchallenger.powers.CounterPower;
import mwchallenger.util.CardStats;

public class Knockout extends BaseCard {
    public static final int DAMAGE = 30;

    public static final String ID = makeID(Knockout.class.getSimpleName());
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.RARE,
            CardTarget.ENEMY,
            3
    );
    public Knockout() {
        super(ID, info);
        setDamage(DAMAGE);
        this.exhaust = true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, this.damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
        if(AbstractDungeon.player.hasPower(makeID(CounterPower.class.getSimpleName()))){
            addToBot(new ApplyPowerAction(m,p, new StunMonsterPower(m)));
        }
    }
}
