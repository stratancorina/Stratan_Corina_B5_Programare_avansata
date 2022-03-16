public interface Storage {
    int getStorageCapacityGB();

    default int getCapacity(Type type) {
        if (type == Type.BYTE)
            return getStorageCapacityGB() * 1_000_000_000;
        else if (type == Type.KILOBYTE)
            return getStorageCapacityGB() * 1_000_000;
        else return getStorageCapacityGB() * 1_000;
    }

}
