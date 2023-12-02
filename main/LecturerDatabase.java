{
    LecturerDatabase(){
        super.general_db = new TreeMap<>();
        super.file_name = "LecturerDB.csv";
        super.loadFromFile();
    }
    @Override
    public void addToDb(Object o) {
        String[] row = o.toString().split(",");
        // Store only the necessary elements, excluding the key
        super.general_db.put(row[0], Arrays.copyOfRange(row, 1, row.length));
        super.saveToFile();
    }
    @Override
    public void removeFromDb(String keyValue){
        super.general_db.remove(keyValue);
        super.saveToFile();
    }

    @Override
    public ArrayList<String> getUniqueIdentifier(){
        return (ArrayList<String>) super.general_db.keySet();
    }
}
