import java.util.Scanner

// Data class untuk item dalam inventorynya
data class Item(
    var name: String,
    var quantity: Int
)

val inventory = mutableListOf<Item>() // Mutable list untuk menyimpan data
val scanner = Scanner(System.`in`) // Scanner untuk input nanti
//test

// Function Tambah Item
fun addItem() {
    print("Masukkan nama item: ")
    val name = scanner.nextLine().trim()

    print("Masukkan jumlah: ")
    val quantity = scanner.nextLine().toIntOrNull() ?: return println("Jumlah harus angka!")

    inventory.add(Item(name, quantity)) // Menambahkan ke list
    println("Item berhasil ditambahkan!")
}

// Function Menampilkan Item
fun showInventory() {
    if (inventory.isEmpty()) {
        println("Inventory kosong.")
    } else {
        println("\nDaftar Inventory:")
        inventory.forEachIndexed { index, item ->
            println("${index + 1}. ${item.name} - ${item.quantity} pcs")
        }
    }
}

// Function Edit Item
fun editItem() {
    showInventory()
    if (inventory.isEmpty()) return

    print("Pilih nomor item yang ingin diedit: ")
    val index = scanner.nextLine().toIntOrNull()?.minus(1) ?: return println("Input tidak valid!")

    if (index in inventory.indices) {
        inventory[index].apply {
            print("Masukkan nama baru (kosongkan jika tidak ingin mengubah): ")
            val newName = scanner.nextLine().trim()
            if (newName.isNotEmpty()) this.name = newName

            print("Masukkan jumlah baru: ")
            val newQuantity = scanner.nextLine().toIntOrNull()
            newQuantity?.let { this.quantity = it }

            println("Item berhasil diedit!")
        }
    } else {
        println("Nomor item tidak ditemukan!")
    }
}

// Fungsi Hapus Item
fun deleteItem() {
    showInventory()
    if (inventory.isEmpty()) return

    print("Pilih nomor item yang ingin dihapus: ")
    val index = scanner.nextLine().toIntOrNull()?.minus(1) ?: return println("Input tidak valid!")

    if (index in inventory.indices) {
        inventory.removeAt(index)
        println("Item berhasil dihapus!")
    } else {
        println("Nomor item tidak ditemukan!")
    }
}

// Fungsi utama (main)
fun main() {
    while (true) {
        println("\n=== SISTEM INVENTORY ===")
        println("1. Tambah Item")
        println("2. Lihat Inventory")
        println("3. Edit Item")
        println("4. Hapus Item")
        println("5. Keluar")
        print("Pilih menu: ")

        when (scanner.nextLine()) {
            "1" -> addItem()
            "2" -> showInventory()
            "3" -> editItem()
            "4" -> deleteItem()
            "5" -> {
                println("Program keluar, Terima Kasih Sudah Mencoba :)")
                break
            }
            else -> println("Pilihan tidak valid!")
        }
    }
}
