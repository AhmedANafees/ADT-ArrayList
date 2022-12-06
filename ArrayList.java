public class ArrayList {

   private int[] items;
   private int numItems;

   public ArrayList() {
      this.items = new int[5];
      this.numItems = 0;
   }

   public static void main(String[] args) {
      ArrayList arrayList = new ArrayList();
      for (int i = 0; i < 11; i++) {
         arrayList.add(i);
         System.out.println(arrayList.get(i));
      }
      arrayList.add(1, 100);
      System.out.println(arrayList.get(7));
      arrayList.remove(7);
      System.out.println(arrayList.get(7));
   }

   /**
    * Adds an intiger to the END of the arrayList.
    * If the size of the arrayList is too small accommodate the new integer, the
    * size of the arraylist will expand
    * 
    * @param element the integer that the user wants to add to END the arrayList
    */
   public void add(int element) {
      if (this.numItems < this.items.length) {
         this.items[numItems] = element;
         numItems++;
      } else {
         int[] temp = new int[this.numItems * 2];
         for (int i = 0; i < this.items.length; i++) {
            temp[i] = this.items[i];
         }
         this.items = temp;
         this.items[numItems] = element;
         numItems++;
      }
   }

   /**
    * adds an integer at a specific index of the arrayList.
    * all indices following indices are moved over to accommodate the new integer
    * 
    * @param index   the index in the arrayList that the new integer value is
    * @param element the new intiget that will be added to the arrayList
    */
   public void add(int index, int element) {
      if (inRange(index)) {
         if (this.numItems < this.items.length) {
            for (int i = numItems; i > index - 1; i--) {
               if (i == index) {
                  this.items[i] = element;
               } else {
                  this.items[i] = this.items[i - 1];
               }
            }
            numItems++;
         } else {
            int[] temp = new int[this.numItems * 2];
            for (int i = 0; i < this.items.length; i++) {
               temp[i] = this.items[i];
            }
            this.items = temp;

            for (int i = numItems; i > index - 1; i--) {
               if (i == index) {
                  this.items[i] = element;
               } else {
                  this.items[i] = this.items[i - 1];
               }
            }
            numItems++;
         }
      }
   }

   /**
    * returns the value of the secified index in the arrayList
    * 
    * @param index the index in the arrayList which the user wants the value of
    * @return the value of the specidied index
    */
   public int get(int index) {
      return this.items[index];
   }

   /**
    * removes the specified index in the arrayList
    * all proceading indecies move over to fill the space in the arrayList
    * 
    * @param index the index in the arrayList that is to be removed
    * @return value of the specified index in the arrayList
    */
   public int remove(int index) {
      int removedInt = 0;
      if (inRange(index)) {
         for (int i = index; i < numItems; i++) {
            if (i == index) {
               removedInt = this.items[index];
            }
            this.items[i] = this.items[i + 1];
         }
         this.numItems--;
      }
      return removedInt;
   }

   /**
    * gets the size of the ArrayList, the number of items in the arrayList
    * 
    * @return the size of the arrayList
    */
   public int size() {
      return this.numItems;
   }

   /**
    * checks if the arrayList is empty or has values in it
    * 
    * @return retruns true if the arrayList is empty, else false
    */
   public boolean isEmpty() {
      return this.numItems == 0;
   }

   /**
    * checks if the input value is within the allowed range for arrayList
    * manipulation
    * 
    * @param index is the index that the user wants to manipulate
    * @return boolean, if true the index is within range, else false
    */
   private boolean inRange(int index) {
      boolean isInRange = true;
      if ((index < 0) || (index > this.numItems)) {
         isInRange = false;
         throw new IndexOutOfBoundsException("Index doesn't exist");
      }
      return isInRange;
   }
}
