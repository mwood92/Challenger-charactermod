package mwchallenger.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import mwchallenger.character.MyCharacter;
import mwchallenger.powers.ParryPower;
import mwchallenger.util.CardStats;

import javax.smartcardio.Card;

public class Riposte extends BaseCard{
    public static final String ID = makeID(Riposte.class.getSimpleName());
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.UNCOMMON,
            CardTarget.ENEMY,
            1
    );

    public Riposte(String ID, CardStats info) {
        super(ID, info);
        setDamage(3);
        super.applyPowers();
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m,new DamageInfo(p,this.damage)));
        addToBot(new ApplyPowerAction(p,p, new ParryPower(p)));

    }
}
