INSERT INTO directory (entity_id, phone_number) VALUES ('123', '999888777') ON CONFLICT (id) DO NOTHING;
INSERT INTO directory (entity_id, phone_number) VALUES ('123', '999888666') ON CONFLICT (id) DO NOTHING;
INSERT INTO directory (entity_id, phone_number) VALUES ('234', '999888777') ON CONFLICT (id) DO NOTHING;
INSERT INTO directory (entity_id, phone_number) VALUES ('345', '999888555') ON CONFLICT (id) DO NOTHING;
