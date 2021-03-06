package graphics;

import game.Consts;
import logic.AnimationTypes;
import logic.Dimension2D;
import logic.PlayerTypes;
import player.Player;

public abstract class AnimationLoader {

    public static Animation loadAnimation(PlayerTypes type, AnimationTypes animType, Player player) {
        String path = AnimationLoader.getPath(type, animType);

        int[] animData = getAnimData(animType, type); // [width, height, pictureCount]

        return Animation.loadAnim(path, animData[0], animData[1], animData[2], player);
    }

    private static String getPath(PlayerTypes type, AnimationTypes animType) {
        return Consts.imageSrc + getTypePath(type) + getAnimSheet(animType);
    }

    private static String getTypePath(PlayerTypes type) {
        if (type==PlayerTypes.Hausperger) {
            return Consts.Hausperger;
        }

        throw new Error("NO SHEET FOUND: " + type);
    }

    private static String getAnimSheet(AnimationTypes type) {
        if (type==AnimationTypes.Default) {
            return Consts.defaultSheet;

        } else if(type==AnimationTypes.Run) {
            return Consts.runSheet;
        } else if(type==AnimationTypes.Fight) {
            return Consts.fightSheet;
        } else if (type==AnimationTypes.SpecialAttack) {
            return Consts.specialAttackSheet;
        }

        throw new Error("NO SHEET FOUND: " + type);
    }

    private static int[] getAnimData(AnimationTypes animType, PlayerTypes type) {
        Dimension2D d = getAnimSpriteSize(type);
        int l = getSheetLength(animType);

        return new int[] { (int)d.getWidth(), (int)d.getHeight(), l};
    }

    private static int getSheetLength(AnimationTypes type) {
        if (type==AnimationTypes.Default) {
            return Consts.defaultPicCount;
        } else if(type==AnimationTypes.Run) {
            return Consts.runPicCount;
        } else if(type==AnimationTypes.Fight) {
            return Consts.fightPicCount;
        } else if (type==AnimationTypes.SpecialAttack) {
            return Consts.specialAttackPicCount;
        }

        throw new Error("NO SHEET FOUND: " + type);
    }

    private static Dimension2D getAnimSpriteSize(PlayerTypes type) {
        if (type==PlayerTypes.Hausperger) {
            return Consts.hauspergerCharacterSize;
        }

        throw new Error("NO SHEET FOUND: " + type);
    }

}
