package blueduck.vounierns_turrets.entity.goal;

import blueduck.vounierns_turrets.entity.AbstractTurret;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.AbstractGolem;

import java.util.EnumSet;

public class TurretSitGoal extends Goal {
    private final AbstractTurret mob;

    public TurretSitGoal(AbstractTurret p_25898_) {
        this.mob = p_25898_;
        this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
    }

    public boolean canContinueToUse() {
        return this.mob.isOrderedToSit();
    }

    public boolean canUse() {

        return this.mob.isOrderedToSit();
    }

    public void start() {
        //this.mob.getNavigation().stop();

        this.mob.setInSittingPose(true);
        this.mob.setSpeed(0);
    }

    public void stop() {
        this.mob.setInSittingPose(false);
    }


}