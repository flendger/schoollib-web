ALTER TABLE `school_lib`.`people`
ADD COLUMN `created_at` DATETIME NULL AFTER `is_deleted`,
ADD COLUMN `updated_at` DATETIME NULL AFTER `created_at`;